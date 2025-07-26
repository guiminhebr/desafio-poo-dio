package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHorario;



    public int getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(int cargaHorario) {
        this.cargaHorario = cargaHorario;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", cargaHorario=" + cargaHorario +
                '}';
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO*cargaHorario;
    }
}
