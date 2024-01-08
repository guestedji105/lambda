package com.tests;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Movie {
    private String title;
    private String genre;
    private double rating;

    Movie(String title, String genre, double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    // Добавьте конструктор и геттеры
    // и метод toString()
    public String toString() {
        return String.format("%s (%s) - %s", title, genre, rating);
    }
}

public class MovieRatingAnalyzer {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Inception", "Sci-Fi", 8.7),
                new Movie("The Dark Knight", "Action", 9.0),
                new Movie("Pulp Fiction", "Crime", 8.9)
                // Можете добавить больше фильмов для разнообразия =)
                // Но в таком случае не забудьте поправить тесты
        );

        // Напишите консьюмера для вывода только названия фильма в консоль
        Consumer<Movie> printingConsumer = movie -> System.out.println(movie.getTitle());

        // Выведем все фильмы
        movies.forEach(printingConsumer);

        // Проверяем методы (используйте assertEquals и assertTrue):
        // Фильмы Sci-Fi должны содержать Inception и только один фильм
        assertEquals(1, filterMoviesByGenre(movies, "Sci-Fi").size());
        assertTrue(filterMoviesByGenre(movies, "Sci-Fi").stream().anyMatch(movie -> movie.getTitle().equals("Inception")));

        // Фильмы с рейтингом выше порога должны иметь только рейтинг выше порога ;)
        assertTrue(filterMoviesByRating(movies, 8.8).stream().allMatch(movie -> movie.getRating() > 8.8));

        // Первый фильм должен быть с самым большим рейтингом (9.0) а последний с самым низким (8.7)
        assertEquals(9.0, sortMoviesByRatingDescending(movies).getFirst().getRating());
        assertEquals(8.7, sortMoviesByRatingDescending(movies).getLast().getRating());
    }

    private static List<Movie> filterMoviesByGenre(List<Movie> movies, String genre) {
        // Фильтруем по жанру
        Predicate<Movie> byGenre = movie -> movie.getGenre().equals(genre);

        return movies.stream()
                .filter(byGenre)
                .collect(Collectors.toList());
    }

    private static List<Movie> filterMoviesByRating(List<Movie> movies, double ratingThreshold) {
        // Фильтруем по рейтингу
        Predicate<Movie> byRating = movie -> movie.getRating() > ratingThreshold;

        return movies.stream()
                .filter(byRating)
                .collect(Collectors.toList());
    }

    private static List<Movie> sortMoviesByRatingDescending(List<Movie> movies) {
        // Сортируем по убыванию рейтинга
        return movies.stream()
                .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
                .toList();
    }
}