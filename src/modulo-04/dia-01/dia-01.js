// Exercicio 01
function gerarPiramide(niveis) {
    var andreNunes = 'R$';
    for (var i = 0; i < niveis; i++) {
        console.log(andreNunes);
        andreNunes += 'R$';
    }
}

// Exercicio 02

function diggletDig() {
    for (var i = 1; i <= 100; i++) {
        if (i % 3 === 0 && i % 5 === 0) {
            console.log('Digglet dig, trio trio trio');
        } else if (i % 5 === 0) {
            console.log('trio trio trio');
        } else if (i % 3 === 0) {
            console.log('Digglet dig');
        } else {
            console.log(i)
        }
    }
}

// Exercicio 03
function Stringuicidade(elem) {
    return typeof elem === 'string';
};
var maiorIgualADois = function (elemento) {
    return elemento >= 2;
};

function find(array, funcao) {
    var tamanhoArray = array.length;
    var arrayDeRetorno = [];
    if (typeof funcao === 'function') { //BONUS 1
        for (var i = 0; i < tamanhoArray; i++) {
            var elemento = array[i];
            if (funcao(elemento)) {
                arrayDeRetorno.push(elemento);
            }
        }
        return arrayDeRetorno;
    }
}

//Exercicio 4

//Exercicio 5

var myCar = new Object();
myCar.make = "Ford";
myCar.model = "Mustang";
myCar.year = 1969;

var myCar2 = new Object();
myCar2.make = "Ford";
myCar2.model = "Mustang";
myCar2.year = 1969;

function iguais(objeto1, objeto2) {
    var ehIgual = false;
    if (objeto1 === objeto2) {
        return true;
    }
    for (var key in objeto1) {
        if (objeto1[key] === objeto2[key]) {
            ehIgual = iguais(objeto1[key], objeto2[key]);
        } else {
            return false;
        }
    }
    return ehIgual;
}

//Exercicio 6

function ctrlC(malElemento) {
    var copiaMalElemento;
    for (var key in malElemento) {
        copiaMalElemento[key] = malElemento[key];
    }
    return copiaMalElemento;
}

//Exercicio 7

function mesclar(elementoMesclado, elemento2) {
    for (var key in elemento2) {
        elementoMesclado[key] = elemento2[key];
    }
}

//BONUS 2

function mesclar(elementoMesclado, elemento2, essaVariavelEhBooleana) {
    if (!essaVariavelEhBooleana) {
        for (var key in elemento2) {
            elementoMesclado[key] = elemento2[key];
        }
    }
}

