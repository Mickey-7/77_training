// - Supervisor: id, firstName, lastName, gender

import { Employee } from './employee';

export class Supervisor {
    id : number;
    firstName : string;
    lastName : string;
    gender : string;
    //invoking array of employees
    employees : Employee[];
}
