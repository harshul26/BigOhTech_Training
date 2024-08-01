function updateObject<T extends object , U extends keyof T>(obj: T , key : U , val : T[U]){
    if(obj.hasOwnProperty(key)){
        obj[key] = val;
        
    }
}



const obj = { a: 1, b: '10', c: true };
const updated = updateObject(obj, 'b', 'world');
console.log(obj);