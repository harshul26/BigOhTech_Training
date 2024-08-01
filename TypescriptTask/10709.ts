interface User {
    age: number;
    name: string;
}

let employee : User = {
    age : 20,
    name : 'harshul',
}

type NullableExample<T> = {
    [k in keyof T]: T[k] extends Object ? NullableExample<T[k]>  : T[k] | null;
    
}
