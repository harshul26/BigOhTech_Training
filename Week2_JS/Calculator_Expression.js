const calculator = (expression) => {

    Array.from(expression).forEach((element) => {
        if (typeValidator(Number(element), 'number') && operatorValidator(element) === false) {
            console.log("error" + element + typeof(element));
            new Error('invalid element in expression');
        }
    });
    return eval(expression);

}

const typeValidator = (number, type) => {
    return typeof(it) === type;
}

const operatorValidator = (op) => {
    return ['+', '-', '*', '/', '%', '(', ')', '[', ']'].includes(op);
}


console.log(calculator("1+(2+3)*4-10/2"));
