
type TransformKeys<T extends Object , U extends { [K in keyof T]?: string }> = {
    [key in keyof T as U[key] extends string ? U[key] : key] : T[key];
}


function transformKeys<T extends Object , U extends { [K in keyof T]?: string }>(obj : T ,keyMap : U): TransformKeys<T , U> {
    const result = {} as TransformKeys<T,U>;
    for(const key in obj){ 
        if(keyMap[key]){
            (result as any)[keyMap[key] as string] = obj[key];
        }
        else{
            (result as any)[key as string] = obj[key]
        }
    }

    return result;
}


const user = {
    firstName: "Tony",
    lastName: "Stark",
    age: 54,
}

const transformUser = transformKeys(user, { firstName: 'first', lastName: 'last' });
console.log(transformUser);