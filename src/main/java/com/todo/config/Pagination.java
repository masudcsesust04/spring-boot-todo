package com.todo.config;

/**
 * Created by masud on 3/1/17.
 */
public class Pagination {

    private int maxPagingButtons = 5;
    private int firstPage;
    private int lastPage;

    public Pagination(int totalPages, int currentPage, int maxPagingButtons) {

        setMaxPagingButtons(maxPagingButtons);

        int halfPagesToShow = getMaxPagingButtons() / 2;

        if (totalPages <= getMaxPagingButtons()) {
            setFirstPage(1);
            setLastPage(totalPages);

        } else if (currentPage - halfPagesToShow <= 0) {
            setFirstPage(1);
            setLastPage(getMaxPagingButtons());

        } else if (currentPage + halfPagesToShow == totalPages) {
            setFirstPage(currentPage - halfPagesToShow);
            setLastPage(totalPages);

        } else if (currentPage + halfPagesToShow > totalPages) {
            setFirstPage(totalPages - getMaxPagingButtons() + 1);
            setLastPage(totalPages);

        } else {
            setFirstPage(currentPage - halfPagesToShow);
            setLastPage(currentPage + halfPagesToShow);
        }

    }

    public int getMaxPagingButtons() {
        return maxPagingButtons;
    }

    public void setMaxPagingButtons(int maxPagingButtons) {
        if (maxPagingButtons % 2 != 0) {
            this.maxPagingButtons = maxPagingButtons;
        } else {
            throw new IllegalArgumentException("Must be an odd value!");
        }
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    @Override
    public String toString() {
        return "Pagination [firstPage=" + firstPage + ", lastPage=" + lastPage + "]";
    }

}
