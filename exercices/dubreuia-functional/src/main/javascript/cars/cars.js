const fs = require('fs');
const {of, from, zip} = require('rxjs');
const {map, filter, take, skipWhile, takeWhile, groupBy, mergeMap, reduce} = require('rxjs/operators');

// TODO change csv file path
const cars = JSON.parse(fs.readFileSync('C:\\Users\\alex\\Projects\\renault-digital-2020\\exercices\\dubreuia-functional\\data\\cars.json', 'utf8'));

/*
 * Imprime les noms de voiture qui contiennent le nom donné, par exemple pour `name = buick` :
 *
 * buick skylark 320
 * buick estate wagon (sw)
 * buick lesabre custom
 *
 * https://www.learnrxjs.io/learn-rxjs/operators/transformation/map
 * https://www.learnrxjs.io/learn-rxjs/operators/filtering/filter
 */
function printCarNamesByName(name) {
    // TODO implement
}

/*
 * Imprime les noms des premières voitures du json, au nombre de "number", par exemple pour `number = 2` :
 *
 * chevrolet chevelle malibu
 * buick skylark 320
 *
 * https://www.learnrxjs.io/learn-rxjs/operators/filtering/take
 * https://www.learnrxjs.io/learn-rxjs/operators/transformation/map
 */
function printFirstCarNames(number) {
    // TODO implement
}

/*
 * Imprime les noms et dates des voitures pour l'année demandé, ne PAS utiliser "filter", on n'utilise
 * que skipWhile et takeWhile, par exemple pour `year = 1975` :
 *
 * plymouth valiant custom - 1975-01-01
 * chevrolet nova - 1975-01-01
 * mercury monarch - 1975-01-01
 *
 * https://www.learnrxjs.io/learn-rxjs/operators/filtering/skipwhile
 * https://www.learnrxjs.io/learn-rxjs/operators/filtering/takewhile
 * https://www.learnrxjs.io/learn-rxjs/operators/transformation/map
 */
function printCarsWhileYearEquals(year) {
    // TODO implement
}

/*
 * Imprime le nom et le compte de voiture pour chaque origine, par exemple :
 *
 * [ 'USA', 254 ]
 * [ 'Europe', 73 ]
 * [ 'Japan', 79 ]
 *
 * https://www.learnrxjs.io/learn-rxjs/operators/transformation/groupby
 * https://www.learnrxjs.io/learn-rxjs/operators/transformation/mergemap
 * https://www.learnrxjs.io/learn-rxjs/operators/combination/zip
 * https://www.learnrxjs.io/learn-rxjs/operators/creation/of
 * https://www.learnrxjs.io/learn-rxjs/operators/transformation/reduce
 */
function printCarsOriginCount() {
    // TODO implement
}

console.log("---------- Cars: buick ----------");
printCarNamesByName("buick");

console.log("---------- Cars: first 10 ----------");
printFirstCarNames(10);

console.log("---------- Cars: while year 1970 ----------")
printCarsWhileYearEquals("1970")

console.log("---------- Cars: while year 1975 ----------")
printCarsWhileYearEquals("1975")

console.log("---------- Cars: group by origin ----------")
printCarsOriginCount()
