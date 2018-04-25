export class User {
    user_id: number;
    fname: string;
    lname: string;
    email_id: string;
    phone_number: string;
    password: string;

constructor(user_id: number, fname: string, lname: string, email_id: string, phone_number: string, password: string) {
    this.user_id=user_id;
    this.fname=fname;
    this.lname=lname;
    this.email_id=email_id;
    this.phone_number=phone_number;
    this.password=password;
    }
}