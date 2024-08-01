type ReverseType< T> = T extends [infer first , ...infer rest] ? [...ReverseType<rest> , first] : []
const arr: [number , string , boolean]  = [42, 'hello', true]
type Test = ReverseType<typeof arr>
console.log(typeof arr);
// console.log(Test);


