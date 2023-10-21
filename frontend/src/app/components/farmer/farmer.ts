import {User} from "../user/user";
import {Order} from "../order/order";
import {Product} from "../product/productList/product";

export class Farmer {
  id!:number;
  name!: any;
  phone!:any;
  password!: any;
  order!:Order;
  availableQuantity!: any;
  products!:Product;
}
