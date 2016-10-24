// Exercicio 01
function gerarPiramide (niveis){
    var andreNunes = 'R$';
    for (var i = 0; i < niveis; i++){
        console.log (andreNunes);
        andreNunes += 'R$';
    }
}

// Exercicio 02

function diggletDig(){
    for (var i = 1; i <=100; i++){
        if (i % 3 === 0 && i % 5 ===0){
            console.log('Digglet dig, trio trio trio');
        } else if (i % 5 === 0) {
            console.log('trio trio trio');
        } else if (i % 3 === 0){
            console.log('Digglet dig');
        } else {
            console.log(i)
        }        
    }
}

// Exercicio 03

var maiorIgualADois = function funcaoParametrizadora (numero){
    return numero >= 2;
}