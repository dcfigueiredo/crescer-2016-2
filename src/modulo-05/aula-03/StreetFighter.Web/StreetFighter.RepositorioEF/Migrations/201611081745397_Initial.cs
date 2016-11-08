namespace StreetFighter.RepositorioEF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Personagem",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Imagem = c.String(),
                        Nome = c.String(nullable: false, maxLength: 255),
                        Nascimento = c.DateTime(nullable: false),
                        Altura = c.Int(nullable: false),
                        Peso = c.Double(nullable: false),
                        Origem = c.String(nullable: false, maxLength: 255),
                        GolpesEspeciaisFamosos = c.String(nullable: false, maxLength: 255),
                        Oculto = c.Boolean(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropTable("dbo.Personagem");
        }
    }
}
