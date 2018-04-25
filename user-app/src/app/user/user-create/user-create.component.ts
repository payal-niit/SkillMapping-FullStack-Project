import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from '@angular/router';

import {UserService} from "../user.service";
import {User} from "../user";
 

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css'],
  providers: [UserService]
})
export class UserCreateComponent implements OnInit, OnDestroy {

  user_id: number;
  user: User;
  users: User[];
  

  userForm: FormGroup;
  private sub: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private userService: UserService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.user_id = params['user_id'];
    });

    this.userForm = new FormGroup({
      fname: new FormControl('', Validators.required),
      phone_number: new FormControl('', Validators.required),
      password: new FormControl('',Validators.required),
      lname: new FormControl('', Validators.required),
      email_id: new FormControl('', [
        Validators.required,
        Validators.pattern("[^ @]*@[^ @]*")        
      ])
    });

    if (this.user_id) { //edit form
      this.userService.findById(this.user_id).subscribe(
        user => {
            this.user_id = user.user_id;
            this.userForm.patchValue({
            fname: user.fname,
            lname: user.lname,
            email_id: user.email_id,
            phone_number: user.phone_number,
            password: user.password
          });
         },error => {
          console.log(error);
         }
      );
    }
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  onSubmit() {
    if (this.userForm.valid) {
      if (this.user_id) {
        let user: User = new User(this.user_id,
          this.userForm.controls['fname'].value,
          this.userForm.controls['lname'].value,
          this.userForm.controls['email_id'].value,
          this.userForm.controls['phone_number'].value,
          this.userForm.controls['password'].value);
        this.userService.updateUser(this.user_id,user).subscribe();
      } else {
        let user: User = new User(null,
          this.userForm.controls['fname'].value,
          this.userForm.controls['lname'].value,
          this.userForm.controls['email_id'].value,
          this.userForm.controls['phone_number'].value,
          this.userForm.controls['password'].value);
        this.userService.saveUser(user).subscribe();
          
      }

      this.userForm.reset();
      location.reload();
      this.router.navigate(['/user']);

    }
  }

  redirectUserPage() {
    location.reload();
    this.router.navigate(['/user']);

  }

}