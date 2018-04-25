import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { UserService } from "../user.service";
import { User } from "../user";
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css'],
  providers: [UserService]
})
export class UserLoginComponent implements OnInit {

  user_id: number;
  user: User;
  users: User[];


  userForm: FormGroup;
  private sub: any;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) { }

  ngOnInit() {


    this.userForm = new FormGroup({
     
      email_id: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
      
    });
  }

  onValidate() {
    let user: User = new User(null,
      null,
      null,
      this.userForm.controls['email_id'].value,
      null,
      this.userForm.controls['password'].value);
      this.userService.validateUser(this.userForm.controls['email_id'].value).subscribe();
      
    this.router.navigate(['/user']);
  }
}
