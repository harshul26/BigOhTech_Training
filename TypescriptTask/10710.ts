interface USER {
    age?: number;
    name: string | null;
}

let person : USER = {
    age : 20,
    name : 'harshul',
}

type DefinedProperties<T> = {
    [key in keyof T]-? : T[key] extends Object ? DefinedProperties<T[key]> : Exclude<T[key], null | undefined>;
}

let object3 : DefinedProperties<USER> = {
    name : 'null',
    age : 20,
}