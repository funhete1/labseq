import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { LabseqService } from './services/labseq.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App {
  n = 0;
  result: string | null = null;

  constructor(private labseqService: LabseqService) {}

  fetch() {
    this.labseqService.getLabseq(this.n).subscribe({
      next: (data: string) => this.result = data,
      error: (err) => {
        console.error('API error', err);
        this.result = 'Error';
      }
    });
  }
}
