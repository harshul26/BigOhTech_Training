const object = {
    "keyOne": "value One",
    "keyTwo": "value Two",
    "keyThree": "value Three",
}

const url = "https://localhost:400";


const queryGenerator = (object, url) => {
    let queryUrl = `${url}` + "?";
    let arr = Object.keys(object);
    arr.forEach((key) => {
        let val = object[key];
        queryUrl += `${key} = ${val}&`;
    })
    queryUrl = queryUrl.substring(0, queryUrl.length - 1);
    return queryUrl;
}

console.log(queryGenerator(object, url));
