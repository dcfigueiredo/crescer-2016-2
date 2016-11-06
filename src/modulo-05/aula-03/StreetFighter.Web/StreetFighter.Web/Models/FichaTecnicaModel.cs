using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        [DisplayName("URL da imagem")]
        public String Imagem { get; set; }
        [Required]
        public String Nome { get; set; }        
        [Required][DisplayName("Data de nascimento")]
        public DateTime Nascimento { get; set; }
        [Required]
        public int Altura { get; set; }
        [Required]
        public double Peso { get; set; }
        [Required]
        public String Origem { get; set; }
        [Required][DisplayName("Golpes Famosos")]
        public String GolpesEspeciaisFamosos { get; set; }
        [DisplayName("Personagem Oculto")]
        public bool Oculto { get; set; }
    }
}