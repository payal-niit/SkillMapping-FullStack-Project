import { Component, OnInit } from '@angular/core';
import { User } from "../user";
import { UserService } from "../user.service";
import { Router } from '@angular/router'
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common'


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [UserService]
})
export class UserListComponent implements OnInit {

  private userlist: User[];

  constructor(private route: ActivatedRoute,
    private location: Location,
    private router: Router,
    private userService: UserService) { }

  ngOnInit() { //when component loading get all users and set the users[]
    this.getAllUsers();
  }

  getAllUsers() {
    this.userService.findAll().subscribe(
      userlist => {
        this.userlist = userlist;
      },
      err => {
        console.log(err);
      }

    );
  }

  deleteUser(user: User) {
    if (user) {
      this.userService.deleteUserById(user.user_id).subscribe(
        res => {
          location.reload();
          this.getAllUsers();

          this.router.navigate(['/user']);
          console.log('done')
        }
      )
    }
  }
  editUserPage(user: User) {
    if (user) {
      this.router.navigate(['/user/edit', user.user_id]);
    }
  }
}