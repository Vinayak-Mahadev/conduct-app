import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Conduct } from '../Conduct';
import { ConductsService } from '../services/conducts.service';

@Component({
  selector: 'app-update-conduct',
  templateUrl: './update-conduct.component.html',
  styleUrls: ['./update-conduct.component.css']
})
export class UpdateConductComponent implements OnInit {

  id: number;
  conduct: Conduct;

  constructor(private route: ActivatedRoute, private router: Router,
    private conductsService: ConductsService) { }

  ngOnInit() {
    this.conduct = new Conduct();

    this.id = this.route.snapshot.params['id'];

    this.conductsService.getConduct(this.id)
      .subscribe(data => {
        console.log(data)
        this.conduct = data;
      }, error => console.log(error));
  }

  updateConduct() {
    this.conductsService.updateConduct(this.conduct.id, this.conduct)
      .subscribe(data => {
        console.log(data);
        this.conduct = data;
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateConduct();
  }

  gotoList() {
    this.router.navigate(['/counduct']);
  }
}
