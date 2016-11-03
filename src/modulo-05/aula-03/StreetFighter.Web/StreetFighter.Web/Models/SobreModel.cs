using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class SobreModel
    {
        public String Nome { get; set; }
        public String PrimeiraAparicao { get; set; }
        public DateTime Nascimento { get; set; }
        public int Altura { get; set; }
        public int Peso { get; set; }
        public String Medidas { get; set; }
        public String TipoSanguineo { get; set; }
        public List<String> HabilidadesEspeciais { get; set; }
        public List<String> Gosta { get; set; }
        public List<String> Desgosta { get; set; }
        public String EstiloDeLuta { get; set; }
        public String Origem { get; set; }
        public String FalaVitoria { get; set; }
        public String NickName1 { get; set; }
        public String NickName2 { get; set; }
        public String NickName3 { get; set; }
        public String Stage1 { get; set; }
        public String Stage2 { get; set; }
        public List<String> GolpesEspeciaisFamosos { get; set; }
    }
}