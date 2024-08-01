// type DeepMergeHelper<T, U> =
//     U extends object ? (
//         T extends object ? DeepMerge<T, U> : U
//     ) : U;

// type DeepMerge<T, U> = {
//     [K in Exclude<keyof T | keyof U, keyof (T & U)>]:
//         K extends keyof T ? (K extends keyof U ? DeepMergeHelper<T[K], U[K]> : T[K]) :
//         K extends keyof U ? U[K] : never;
// };

// function deepMerge<T extends object,U extends object>(obj1:T, obj2:U): DeepMerge<T,U> {

//     const isObject = (obj : T|U|(DeepMerge<T,U>)) => obj && typeof obj === 'object' && !Array.isArray(obj);

//     const merge = (target : DeepMerge<T,U> , source : T|U): void  => {
//         Object.keys(source).forEach(key => {
//             if (isObject(source[key])) {
//                 if (!target[key]) {
//                     target[key] = {};
//                 }
//                 merge(target[key], source[key]);
//             } else {
//                 if (target[key] !== undefined && typeof target[key] !== typeof source[key]) {
//                     throw new TypeError(`Type mismatch for key "${key}": ${typeof target[key]} vs ${typeof source[key]}`);
//                 }
//                 target[key] = source[key];
//             }
//         });
//     };

//     const result = { ...obj1 } as DeepMerge<T,U>;
//     merge(result, obj2);
//     return result;
// }

// const obj1 = { a: 1, b: { c: 2 } };
// const obj2 = { b: { d: 3 }, e: 4 };
// const merged = deepMerge(obj1, obj2);

// console.log(merged);
// // Output: { a: 1, b: { c: 2, d: 3 }, e: 4 }

type DeepMergeHelper<T, U> =
    U extends object ? (
        T extends object ? DeepMerge<T, U> : U
    ) : U;

type DeepMerge<T extends object, U extends object> =
    U extends any[] ? T : {
        [K in keyof (T & U)]:
            K extends keyof U ? (K extends keyof T ? DeepMergeHelper<T[K], U[K]> : U[K]) :
            K extends keyof T ? T[K] : never;
    };

function deepMerge<T extends object, U extends object>(obj1: T, obj2: U): DeepMerge<T, U> {
    const mergeObjects = (target: any, source: any): any => {
        Object.keys(source).forEach(key => {
            if (typeof source[key] === 'object' && source[key] !== null && !Array.isArray(source[key])) {
                if (!target[key]) {
                    target[key] = {};
                }
                mergeObjects(target[key], source[key]);
            } else {
                target[key] = source[key];
            }
        });
    };

    const result = { ...obj1 };
    mergeObjects(result, obj2);
    return result as DeepMerge<T, U>;
}

// Example usage:
const obj1 = { a: 1, b: { c: 2 } };
const obj2 = { b: { d: 3 }, e: 4 };
const merged = deepMerge(obj1, obj2);
console.log(merged);
// TypeScript will infer the type of merged as { a: number; b: { c: number; d: number; }; e: number; }

