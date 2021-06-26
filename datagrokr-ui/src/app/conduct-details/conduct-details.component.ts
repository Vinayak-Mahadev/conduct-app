import { Component, OnInit } from '@angular/core';
import { Conduct } from '../Conduct';
import { ConductsService } from '../services/conducts.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-conduct-details',
  templateUrl: './conduct-details.component.html',
  styleUrls: ['./conduct-details.component.css']
})
export class ConductDetailsComponent implements OnInit 
{
  id: number;
  conduct: Conduct;

  constructor(private route: ActivatedRoute,private router: Router,
    private conductsService: ConductsService) { }

  ngOnInit(): void {
    this.conduct = new Conduct();

    this.id = this.route.snapshot.params['id'];
    
    this.conductsService.getConduct(this.id)
      .subscribe(data => {
        console.log(data)
        this.conduct = data;
      }, error => console.log(error));

  }

  list(){
    this.router.navigate(['conducts']);
  }

}
