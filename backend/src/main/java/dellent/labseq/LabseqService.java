package dellent.labseq;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LabseqService {
    private int maxComputed = 3;                                                //index of last base case
    private final Map<Integer, BigInteger> cache = new ConcurrentHashMap<>();    //cache structure to avoid redundant work

    private final Lock lock = new ReentrantLock();                                        //will serve as a mutex  

    public LabseqService() {
        //base cases
        cache.put(0, BigInteger.ZERO);
        cache.put(1, BigInteger.ONE);
        cache.put(2, BigInteger.ZERO);
        cache.put(3, BigInteger.ONE);
    }

   public BigInteger labseq(Integer n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        //fastes exist for already computed values
        if(cache.containsKey(n)){
            return cache.get(n);
        }

        //compute in interactive way if not in the cache
        //one thread at time, avoid race conditions
        synchronized (lock){  
            for (int i = maxComputed + 1; i <= n; i++) {
                BigInteger value = cache.get(i - 4).add(cache.get(i - 3));
                cache.put(i, value);
            }
            maxComputed = Math.max(maxComputed, n);            //keep track of the max element compute so far to avoid calculating twice
        }

        return cache.get(n);
    }
}
