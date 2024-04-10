package com.aluracursos.screenmatch.modelos;

public class Titulo {

        private String nombre;
        private int fechaDeLanzamiento;
        private int duracionEnMinutos;
        private boolean incluidoEnElPlan;
        private double sumaDeEvaluaciones;
        private int totalDeEvaluaciones;

        public String getNombre() {
            return nombre;
        }

        public int getFechaDeLanzamiento() {
            return fechaDeLanzamiento;
        }

        public int getDuracionEnMinutos() {
            return duracionEnMinutos;
        }

        public boolean isIncluidoEnElPlan() {
            return incluidoEnElPlan;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
            this.fechaDeLanzamiento = fechaDeLanzamiento;
        }

        public void setDuracionEnMinutos(int duracionEnMinutos) {
            this.duracionEnMinutos = duracionEnMinutos;
        }

        public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
            this.incluidoEnElPlan = incluidoEnElPlan;
        }

        public int getTotalDeEvaluaciones() {
            return totalDeEvaluaciones;
        }

        public void muestraFichaTecnica() {
            System.out.println("El nombre de la película es: " + getNombre());
            System.out.println("Su fecha de lanzamiento es: " + getFechaDeLanzamiento());
            System.out.println("Su duración en minutos es: " + getDuracionEnMinutos());
            System.out.println("Pelicula incluida en el plan: " + isIncluidoEnElPlan());
        }

        public void evalua(double nota) {
            sumaDeEvaluaciones += nota;
            totalDeEvaluaciones++;
        }

        public double calculaMedia() {
            return sumaDeEvaluaciones / totalDeEvaluaciones;
        }

    }
