import { Component, OnInit } from '@angular/core';
import { Observable } from "rxjs";
import { Conduct } from '../Conduct';
import { ConductsService } from '../services/conducts.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-conduct-list',
  templateUrl: './conduct-list.component.html',
  styleUrls: ['./conduct-list.component.css']
})
export class ConductListComponent implements OnInit {

  conducts : Observable<Conduct[]>;

  constructor(private conductsService: ConductsService,
    private router: Router) {}

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.conducts = this.conductsService.getConductsList();
  }
  
  deleteConduct(id: number) {
    this.conductsService.deleteConduct(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  conductDetails(id: number){
    this.router.navigate(['details', id]);
  }

  updateConduct(id: number){
    this.router.navigate(['update', id]);
  }
}
