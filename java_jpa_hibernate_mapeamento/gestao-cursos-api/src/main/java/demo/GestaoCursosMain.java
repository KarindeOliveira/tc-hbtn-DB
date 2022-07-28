package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestaoCursosMain {
    public static void main(String[] args) {
        AlunoModel alunoModel = new AlunoModel();
        CursoModel cursoModel = new CursoModel();

        Professor professor = new Professor();
        Telefone telefone = new Telefone();
        Curso curso = new Curso();
        Aluno aluno = new Aluno();
        Endereco endereco = new Endereco();
        MaterialCurso materialCurso = new MaterialCurso();
        List<Telefone>listaTelefone = new ArrayList<>();
        List<Endereco>listaEndereco = new ArrayList<>();
        List<Aluno> listaAluno = new ArrayList<>();

        telefone.setDDD("21");
        telefone.setNumero("987756437");

        endereco.setEndereco("Rua alcapão pequeno");
        endereco.setLogradouro("casa");
        endereco.setNumero("7");
        endereco.setBairro("Marechal Hermes");
        endereco.setCep(12345678);
        endereco.setCidade("Rio de Janeiro");
        endereco.setEstado("Rio de Janeiro");

        aluno.setEmail("karin@karin.com");
        aluno.setMatricula("12345");
        aluno.setNomeCompleto("Karin Pinheiro");
        listaTelefone.add(telefone);
        aluno.setTelefones(listaTelefone);
        listaEndereco.add(endereco);
        aluno.setEnderecos(listaEndereco);
        aluno.setNascimento(LocalDate.of(1999, 05, 14));
        listaAluno.add(aluno);
        alunoModel.create(aluno);

        professor.setEmail("osavaldo@osvaldo.com");
        professor.setMatricula("te03417");
        professor.setNomeCompleto("Osvaldo Aranha");

        curso.setMaterial(materialCurso);
        curso.setAlunos(listaAluno);
        curso.setNome("Ciencia de dados");
        curso.setSigla("CD");
        curso.setProfessor(professor);

        materialCurso.setCurso(curso);
        materialCurso.setUrl("https://www.google.com/");

        cursoModel.create(curso);

        //2) Buscando todos os alunos na base de dados
        List<Aluno> alunos = alunoModel.findAll();
        for (Aluno aluno1:alunos) {
            System.out.println(aluno1.getId()+" "+aluno1.getNomeCompleto()+" "+aluno1.getNascimento()+" "
                    +aluno1.getEmail()+" "+aluno1.getMatricula()+" "+aluno1.getTelefones()+" "+
                    aluno1.getEnderecos());
        }

        //3) Buscar um Aluno por Id
        Aluno aluno1 = alunoModel.findById(aluno.getId());
        System.out.println(aluno1.getId()+" "+aluno1.getNomeCompleto()+" "+aluno1.getNascimento()+" "
                +aluno1.getEmail()+" "+aluno1.getMatricula()+" "+aluno1.getTelefones()+" "+
                aluno1.getEnderecos());

        //4) Deletar um aluno
        alunoModel.delete(aluno1);
        List<Aluno> pessoaList = alunoModel.findAll();
        System.out.println(pessoaList.stream().map(Aluno::getMatricula).collect(Collectors.toList()));

        //5) Atualizar Aluno
        aluno.setEmail("osvaldoaranha@osvaldo.com");
        aluno.setMatricula("54632");
        aluno.setNomeCompleto("Jose da SIlva");
        listaTelefone.add(telefone);
        aluno.setTelefones(listaTelefone);
        listaEndereco.add(endereco);
        aluno.setEnderecos(listaEndereco);
        aluno.setNascimento(LocalDate.of(1999, 05, 14));
        listaAluno.add(aluno);

        Aluno alunoModelById = alunoModel.findById(aluno.getId());
        System.out.println("Aluno atualizado: ");
        System.out.println(aluno1.getId()+" "+aluno1.getNomeCompleto()+" "+aluno1.getNascimento()+" "
                +aluno1.getEmail()+" "+aluno1.getMatricula()+" "+aluno1.getTelefones()+" "+
                aluno1.getEnderecos());

        //2) Buscando todos os cursos na base de dados
        List<Curso> cursos = cursoModel.findAll();
        for (Curso curso1: cursos) {
            System.out.println(curso1.getId()+" "+curso1.getNome()+" "+curso1.getMaterial()+" "
                    +curso1.getAlunos()+" "+curso1.getProfessor()+" "+curso1.getSigla());
        }

        //3) Buscar um Curso por Id
        Curso curso1 = cursoModel.findById(curso.getId());
        System.out.println(curso1.getId()+" "+curso1.getNome()+" "+curso1.getMaterial()+" "
                +curso1.getAlunos()+" "+curso1.getProfessor()+" "+curso1.getSigla());

        //4) Deletar um curso
        cursoModel.delete(curso1);

        List<Curso> cursoList = cursoModel.findAll();
        System.out.println(cursoList.stream().map(Curso::getNome).collect(Collectors.toList()));

        //5) Atualizar Curso
        curso.setMaterial(materialCurso);
        curso.setAlunos(listaAluno);
        curso.setNome("Curso de Java");
        curso.setSigla("Java");
        curso.setProfessor(professor);
        materialCurso.setCurso(curso);
        materialCurso.setUrl("www.google.com");


        Curso cursoModelById = cursoModel.findById(curso.getId());
        System.out.println("Curso atualizado: ");
        System.out.println(curso1.getId()+" "+curso1.getNome()+" "+curso1.getMaterial()+" "
                +curso1.getAlunos()+" "+curso1.getProfessor()+" "+curso1.getSigla());

    }

}
