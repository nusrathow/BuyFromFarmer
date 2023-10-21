
import {User} from "../user/user";

export class Checkout {
  id!:number;
  order!: any;
  total!:number;
  user!: User;
  address!:String;
}
