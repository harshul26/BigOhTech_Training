interface User {
    name : string ;
    id : number;
    age : number;
    gender : string;
};

const user  = {
    name : 'harshul',
    id : 101,
    age : 21,
    gender : 'female'
} as const;

type keyType = keyof User ;

function flatGet<typeO >(obj : typeO , key: keyof typeO ) : any{
    return obj[key];
}

const value = flatGet(user , 'name');

console.log(value);
