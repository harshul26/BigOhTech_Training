const person2 = {
    name: {
        firstName : 'Harshul',
    },
    id: 101,
    age: 21,
    gender: 'female',
    address: {
        city: 'Delhi',
        zip: '110052',
    },
} as const;

type Path<T> = T extends Object ? {
    [K in keyof T]: K | `${K & string}.${Path<T[K]> & string}`
}[keyof T] : never;

type Paths<T> = Path<T> | Path<T>[];

function deepGet<T , K extends Paths<T>>(obj : T , keys : K | string[]) : any {
    
    let keysArr = typeof keys === 'string' ? (keys.split('.') as string[]) : (keys as string[]);

    return keysArr.reduce<any>((acc , key) =>{
        if(acc !== null && acc !== undefined){
            return acc[key];
        }
    },obj);
    
}

const value1 = deepGet(person2, 'address');
console.log(value1); 

const value22 = deepGet(person2, ['address' , 'city']);
console.log(value22); // Output: 10001 

interface user {
    name : string;
    nqm : String;
}