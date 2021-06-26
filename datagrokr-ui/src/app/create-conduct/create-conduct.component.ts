import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Conduct } from '../Conduct';
import { ConductsService } from '../services/conducts.service';

@Component({
  selector: 'app-create-conduct',
  templateUrl: './create-conduct.component.html',
  styleUrls: ['./create-conduct.component.css']
})
export class CreateConductComponent implements OnInit {

  conduct: Conduct = new Conduct();
  submitted = false;
  constructor(private conductsService: ConductsService, private router: Router) {

  }

  ngOnInit(): void {
  }

  newConduct(): void {
    this.submitted = false;
    this.conduct = new Conduct();
  }

  save() {
    this.conductsService
      .createConduct(this.conduct).subscribe(data => {
        console.log(data)
        this.conduct = data;
        this.gotoList();
      },
        error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }
  gotoList() {
    this.router.navigate(['/conducts']);
  }
}
