type K = string | number | symbol;

type CallBackType<V , U> = (values : V) => U;

function mapObject<V , U>(object : Record<K,V> , callBack : CallBackType<V , U>) : Record<K, U> {
let result : Record<K , U> = {};

for(let k in object){
    if(object.hasOwnProperty(k)){
        if(typeof object[k] === 'object' && object[k] !== null){
            result[k] = mapObject(object[k] as Record<K , V>, callBack) as U;
        }else{
            result[k] = callBack(object[k]);
        }
    }
}
return result;
}

const obj_1 = { a: '1', b: '2', c: '3' };

const mappedObject = mapObject(obj_1, (value) => parseInt(value));
console.log(mappedObject);

