import { Component, OnInit } from '@angular/core';
import { CommerceService } from 'src/app/services/commerce.service';
import { ServicesService } from 'src/app/services/services.service';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { TurnsService } from 'src/app/services/turns.service';

@Component({
  selector: 'app-turns',
  templateUrl: './turns.component.html',
  styleUrls: ['./turns.component.scss']
})
export class TurnsComponent implements OnInit {

  commerces : any ;
  services : any ;
  turns : any;
  commerceSelected : any;
  serviceSelected : any;
  date_start!: NgbDateStruct;
  date_end!: NgbDateStruct;
  error = "";
  time_open = "";
  time_end = ""

  constructor(private commerceService: CommerceService,
              private servicesService: ServicesService,
              private calendar: NgbCalendar,
              private turnService: TurnsService,
            ) { }

  ngOnInit(): void {
    this.getAllCommerce();
    this.getAllTurns();
  }

  private getAllCommerce(){
    this.commerceService.getAll().
    subscribe((resp:any)=>{
      this.commerces = resp;
    },error=>{
      console.error(error)
    })
  } 

  public getServicesByCommerce(){

    this.servicesService.getByCommerce(this.commerceSelected).
    subscribe((resp:any)=>{
      this.services = resp;
      console.log(this.services)
    },error=>{
      console.error(error);
    })
  }

  public showTimes(){

    this.time_open = "";
    this.time_end = "";
    
    let services = this.services.filter((s:any) => s.id == this.serviceSelected);

    this.time_open = services[0].time_open;
    this.time_end  = services[0].time_end;
  }

  private createDate(date : NgbDateStruct){
    let month = (''+date.month).length < 2 ? '0'+date.month : ''+date.month;
    let day = (''+date.day).length < 2 ? '0' + date.day : ''+date.day;

    console.log('date.month',month);
    console.log('date.day',day);
    return date.year+'-'+month+'-'+day;
  }

  createTurns(){
    this.error = "";
    if(this.commerceSelected == "-1" || this.serviceSelected == "-1" ||
       this.date_start == undefined || this.date_end == undefined  ){
         this.error = "Todos los campos deben estar llenos";
         return;
       }
    console.log('date_start',this.date_start);
    console.log('date_start',this.date_end);
    console.log('id',(this.serviceSelected));
    this.turnService.createTurns({
                                  "id":parseInt(this.serviceSelected),
                                  "date_start":this.createDate(this.date_start),
                                  "date_end":this.createDate(this.date_end)
                                }).
    subscribe((resp:any)=>{
      this.getAllTurns();
    },error=>{
      console.error(error);
    })
  }

  public getAllTurns(){
    this.turnService.getAll().
    subscribe((resp:any)=>{
      console.log(resp);
      this.turns = resp;
    },error=>{
      console.error(error);
    })
  }
  
  closeAlert(){
    this.error = "";
  }

}
