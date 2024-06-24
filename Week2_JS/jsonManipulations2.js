
function flattenObject(source, parentKey = '', result = {}) {
    Object.keys(source).forEach((key) => {

        //console.log(key);
        let newKey = '';
        if (parentKey !== '') {
            newKey = `${parentKey}.${key}`;
        } else {
            let str = "";
            newKey = `${ key }${str}`;
            //console.log(newKey);
        }


        if (source[key] instanceof Object) {
            flattenObject(source[key], newKey, result);
        } else {
            result[newKey] = source[key];
        }

    });

    return result;
}

// Example usage:
const input = {
    "keyOne": "value One",
    "keyTwo": "value Two",
    "keyThree": "value Three",
    "keyFour": {
        "keyA": true,
        "keyB": false,
        "keyC": {
            "keyCOne": "key C one value",
            "keyCTwo": "key C two value",
            "keyCThree": {
                "keyDOne": "key D one value",
                "keyDTwo": "key D two value",
                "keyDThree": 1234
            }
        }

    }
};

const flattened = flattenObject(input);
console.log(flattened);
