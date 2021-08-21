package model;

public class ModelUsuario extends ModeloPessoa{
        private String pesquisa;
        private String dataInsercao;
        private String dataNascimento;
        public String getDataInsercao() {
            return dataInsercao;
        }

        public void setDataInsercao(String dataInsercao) {
            this.dataInsercao = dataInsercao;
        }
    
    
        public String getPesquisa() {
            return pesquisa;
        }

        public void setPesquisa(String pesquisa) {
            this.pesquisa = pesquisa;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public void setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
        }   
}

