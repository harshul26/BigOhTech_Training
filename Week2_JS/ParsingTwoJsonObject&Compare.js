const printObj = function(obj) {
    let string = '{';

    for (let prop in obj) {
        if (obj[prop] instanceof Object) {
            string += prop + ': { ' + printObj(obj[prop]) + '}';

        } else {
            string += prop + ': ' + obj[prop] + '; ';
        }
    }
    string += '}'
    return string;
}
const comparingJsonObjects = (actual, expected) => {
    const arrKeysEx = Object.keys(expected);
    const arrKeysAc = Object.keys(actual);

    // console.log(actual)
    // console.log(expected);
    // console.log(arrKeysAc.length);
    // console.log(arrKeysEx.length);
    if (arrKeysAc.length !== arrKeysEx.length) {
        return false;
    }

    let flag = true;
    arrKeysEx.forEach((key) => {
        if (actual.hasOwnProperty(key) && flag) {
            // console.log(typeof actual[key]);
            // console.log(typeof expected[key]);
            // console.log(typeof actual[key] === typeof expected[key])
            if (typeof actual[key] !== typeof expected[key]) {

                flag = false;
            } else if (typeof actual[key] === Object && typeof expected[key] === Object) {
                if (!comparingJsonObjects(actual[key], expected[key])) {

                    flag = false;
                }
            } else if (actual[key] !== expected[key]) {

                flag = false;
            }

        }
    });
    if (!flag) {
        return false;
    }
    return true;
}

const mainFunction = (actual, expected, str) => {

        const result = comparingJsonObjects(actual, expected);
        const objEx = printObj(expected);
        const objAc = printObj(actual);
        if (result) {
            str = 'Passed';
        } else {
            str = `FAILED Expected  ${objEx}, but got ${objAc}`
        }

        return str;
    }
    // var expected = { bar: 6, foo: 5 };
    // var actual = { foo: 5, bar: { a: 's', b: 's2' } };
let expected = { foo: 6, bar: 5 };

let actual = { bar: 6, foo: 6, bar: 5 }

console.log(mainFunction(actual, expected, 'efdef'));
