console.log('Olá JS!');

console.log("Nome:", elfo.nome);
elfo.flechas = 42;
delete elfo.flechas;
elfo["Nome Completo"] = "Legolas da Silva";
elfo.atirarFlecha = function (dwarf){
    dwarf.vida -=10;
    elfo.experiencia ++;
}
elfo.atirarFlecha ( {vida: 110} );
exibirElfoNaTela(elfo);
console.log(elfo);