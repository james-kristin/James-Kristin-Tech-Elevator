package com.techelevator;

import java.math.BigDecimal;
import java.util.*;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int TITLE_FIELD = 0;
    private static final int AUTHOR_FIELD = 1;
    private static final int PUBLISHED_YEAR_FIELD = 2;
    private static final int PRICE_FIELD = 3;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> titles = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<Integer> publishedYears = new ArrayList<>();
    private List<BigDecimal> prices = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();

    }

    private void loadData() {

        String[] dataset = Dataset.load();

        for (String data : dataset) {
           String[] splitData = data.split(FIELD_DELIMITER);
           titles.add(splitData[TITLE_FIELD]);
           authors.add(splitData[AUTHOR_FIELD]);
           publishedYears.add(Integer.parseInt(splitData[PUBLISHED_YEAR_FIELD]));
           prices.add(BigDecimal.valueOf(Double.parseDouble(splitData[PRICE_FIELD])));
        }
    }

    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        displayTitlesList(titles);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(authors);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(publishedYears);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(prices);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            }
            else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        // Search by title
                        String filterTitle = promptForString("Enter title: ");
                        /*
                         Requirement: 3b
                         Replace `displayTitlesList(titles)` with calls to the
                         `filterByTitle()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByTitle(filterTitle), TITLE_FIELD);

                    } else if (searchBooksMenuSelection == 2) {
                        // Search by author
                        String filterAuthor = promptForString("Enter author: ");
                        /*
                         Requirement: 4b
                         Replace `displayAuthorsList(authors)` with calls to the
                         `filterByAuthor()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByAuthor(filterAuthor), AUTHOR_FIELD);
                    } else if (searchBooksMenuSelection == 3) {
                        // Search by published year
                        int filterYear = promptForPublishedYear("Enter date (YYYY): ");
                        /*
                         Requirement: 5b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYear()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByPublishedYear(filterYear), PUBLISHED_YEAR_FIELD);
                    } else if (searchBooksMenuSelection == 4) {
                        // Search by published year range
                        int filterFromYear = promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        /*
                         Requirement: 6b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYearRange()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByPublishedYearRange(filterFromYear, filterToYear), PUBLISHED_YEAR_FIELD);
                    } else if (searchBooksMenuSelection == 5) {
                        // Find the most recent books
                        /*
                         Requirement: 7b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `findMostRecentBooks()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(findMostRecentBooks(), PUBLISHED_YEAR_FIELD);
                    } else if (searchBooksMenuSelection == 6) {
                        // Search by price
                        double filterPrice = promptForPrice("Enter price: ");
                        /*
                         Requirement: 8b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPrice()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByPrice(filterPrice), PRICE_FIELD);
                    } else if (searchBooksMenuSelection == 7) {
                        // Search by price range
                        double filterFromPrice= promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = promptForPrice("Enter \"to\" price: ");
                        /*
                         Requirement: 9b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPriceRange()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(filterByPriceRange(filterFromPrice, filterToPrice), PRICE_FIELD);
                    } else if (searchBooksMenuSelection == 8) {
                        // Find the least expensive books
                        /*
                         Requirement: 10b
                         Replace `displayPricesList(prices)` with calls to the
                         `findLeastExpensiveBooks()` and `displaySearchResults()` methods.
                         */
                        displaySearchResults(findLeastExpensiveBooks(), PRICE_FIELD);
                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }

    }


     private void displaySearchResults(List<Integer> indexes, int primaryField){
        List<String> sortedList = new ArrayList<>();
        Map<String, Integer> sortedMap = new HashMap<>();

        if(primaryField == TITLE_FIELD) {
            for (int index : indexes) {
                sortedList.add(titles.get(index));
            }

            Collections.sort(sortedList);

            for (String title : sortedList) {
                System.out.println(title + ": " + authors.get(titles.indexOf(title)) + ": " + publishedYears.get(titles.indexOf(title)) + ": $" + prices.get(titles.indexOf(title)));
            }

        } else if (primaryField == AUTHOR_FIELD) {
            for (int index : indexes) {
//               sortedMap.put(authors.get(index), index);
                System.out.println(authors.get(index) + ": " + titles.get(index) + ": " + publishedYears.get(index) + ": $" + prices.get(index));
            }

//            Collections.sort(sortedList);

//            for (String author : sortedList) {
//                System.out.println(author + ": " + titles.get(authors.indexOf(author)) + ": " + publishedYears.get(authors.indexOf(author)) + ": $" + prices.get(authors.indexOf(author)));
//           }

        } else if (primaryField == PUBLISHED_YEAR_FIELD) {
            for (int index : indexes) {
                System.out.println(publishedYears.get(index) + ": " + titles.get(index) + ": " + authors.get(index) + ": $" + prices.get(index));
            }
        } else if (primaryField == PRICE_FIELD) {
            for (int index : indexes) {
                System.out.println("$" + prices.get(index) + ": " + titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index));
            }
        }
     }

    /*
     Requirement: 3a
     Complete the `filterByTitle()` method.
     See README for additional details.
     <title>: <author>: <publication year>: $<price>
     */
    private List<Integer> filterByTitle(String filterTitle) {
        List<Integer> indexes = new ArrayList<>();
        for (String title : titles) {
            if ((title.toLowerCase()).contains(filterTitle.toLowerCase())) {
                indexes.add(titles.indexOf(title));
            }
        }


        return indexes;
    }

    /*
     Requirement: 4a
     Complete the `filterByAuthor()` method.
     See README for additional details.
     */
    private List<Integer> filterByAuthor(String filterAuthor) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < authors.size(); i++) {
            if (((authors.get(i)).toLowerCase()).contains(filterAuthor.toLowerCase())) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /*
     Requirement: 5a
     Complete the `filterByPublishedYear()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYear(int filterYear) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) == filterYear) {
                indexes.add(i);
            }
        }
        return indexes;
}

    /*
     Requirement: 6a
     Complete the `filterByPublishedYearRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPublishedYearRange(int filterFromYear, int filterToYear) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) >= filterFromYear && publishedYears.get(i) <= filterToYear) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /*
     Requirement: 7a
     Add the `private List<Integer> findMostRecentBooks()` method.
     See README for additional details.
     */
    private List<Integer> findMostRecentBooks() {
        List<Integer> indexes = new ArrayList<>();
        int newestYear = 0;
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) >= newestYear) {
                newestYear = publishedYears.get(i);
            }
        }
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) == newestYear) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /*
     Requirement: 8a
     Complete the `filterByPrice()` method.
     See README for additional details.
     */
    private List<Integer> filterByPrice(double filterPrice) {
        List<Integer> indexes = new ArrayList<>();
        BigDecimal bigPrice = new BigDecimal(filterPrice);
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(bigPrice) <= 0) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /*
     Requirement: 9a
     Complete the `filterByPriceRange()` method.
     See README for additional details.
     */
    private List<Integer> filterByPriceRange(double filterFromPrice, double filterToPrice) {
        List<Integer> indexes = new ArrayList<>();
        BigDecimal bigLowPrice = new BigDecimal(filterFromPrice);
        BigDecimal bigHighPrice = new BigDecimal(filterToPrice);
        for (int i = 0; i < prices.size(); i++) {
            if ((prices.get(i).compareTo(bigLowPrice)) >= 0 && (prices.get(i).compareTo(bigHighPrice) <= 0)) {
                indexes.add(i);
            }
        }
        return indexes;
    }

    /*
     Requirement: 10a
     Add the `private List<Integer> findLeastExpensiveBooks()` method.
     See README for additional details.
     */
    private List<Integer> findLeastExpensiveBooks() {
        List<Integer> indexes = new ArrayList<>();

        BigDecimal leastExpensive= new BigDecimal(20);

        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(leastExpensive) <= 0) {
                leastExpensive = prices.get(i);
            }
        }
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).equals(leastExpensive)) {
                indexes.add(i);
            }
        }
        return indexes;

    }


    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display data and subsets");
        System.out.println("2: Search books");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void printDataAndSubsetsMenu() {
        System.out.println("1: Display dataset");
        System.out.println("2: Display titles");
        System.out.println("3: Display authors");
        System.out.println("4: Display published years");
        System.out.println("5: Display prices");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void printSearchBooksMenu() {
        System.out.println("1: Search by title");
        System.out.println("2: Search by author");
        System.out.println("3: Search by published year");
        System.out.println("4: Search by published year range");
        System.out.println("5: Find most recent books");
        System.out.println("6: Search by price");
        System.out.println("7: Search by price range");
        System.out.println("8: Find least expensive books");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void displayDataset(String[] dataset) {
        System.out.println("Dataset");
        System.out.println("-------");
        for (String data : dataset) {
            System.out.println(data);
        }
        System.out.println();
        promptForReturn();
    }

    private void displayTitlesList(List<String> titles) {
        System.out.println("Titles");
        System.out.println("-------");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(i + ": " + titles.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayAuthorsList(List<String> authors) {
        System.out.println("Authors");
        System.out.println("-------");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i + ": " + authors.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPublishedYearsList(List<Integer> publishedYears) {
        System.out.println("Published Years");
        System.out.println("---------------");
        for (int i = 0; i < publishedYears.size(); i++) {
            System.out.println(i + ": " + publishedYears.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPricesList(List<BigDecimal> prices) {
        System.out.println("Prices");
        System.out.println("------");
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(i + ": " + prices.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private int promptForPublishedYear(String prompt) {
        int year;
        while (true) {
            System.out.println(prompt);
            try {
                year = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The year provided is not well-formed. It must be YYYY.");
            }
        }
        return year;
    }

    private double promptForPrice(String prompt) {
        double price;
        while (true) {
            System.out.println(prompt);
            try {
                price = Double.parseDouble(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The price provided is not a valid monetary value.");
            }
        }
        return price;
    }

    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
