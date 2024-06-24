const minimumBracketReversal = (expression) => {
    let arr = [];
    let exp = expression.split("");
    exp.forEach(element => {
        if (element === '{') {
            arr.push(element);
        } else if (element === '}') {
            arr.pop();
        }
    });

    if (arr.length % 2 == 0) {
        return arr.length / 2;
    } else {
        return -1;
    }
}
let expression = '{{{{}}'
console.log(minimumBracketReversal(expression));
