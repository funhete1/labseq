FROM node:alpine

WORKDIR /app/front/

COPY . /app/front/

RUN npm install -g @angular/cli && npm install

EXPOSE 4200

CMD ["ng", "serve", "--host", "0.0.0.0"]
