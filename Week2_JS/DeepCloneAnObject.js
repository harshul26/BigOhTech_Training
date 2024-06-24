function deepCloneAnObject(object) {

    if (object === null || typeof object !== 'object') {
        return object;
    }

    let cloneObject = Array.isArray(object) ? [] : {};

    for (let key in object) {
        cloneObject[key] = deepCloneAnObject(object[key])
    }
    return cloneObject;
}


const object = {
    name: "John Doe",
    age: 14,
    test: [
        [1],
        {
            name: 'test'
        }
    ],
    status: {
        verified: false,
        method: Symbol(),
        title: undefined
    }
};
console.log(object);


let cloneObject = deepCloneAnObject(object);
//console.log(cloneObject);


cloneObject.name = "abc";

console.log(cloneObject);
