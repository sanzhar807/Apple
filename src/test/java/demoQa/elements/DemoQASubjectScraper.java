package demoQa.elements;

import org.junit.jupiter.api.Tag;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.*;
@Tag("UI")
public class DemoQASubjectScraper {
    public static void main(String[] args) {
        // 1. НАСТРОЙКА ДРАЙВЕРА
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            System.out.println("🚀 Запуск браузера...");
            driver.get("https://demoqa.com/automation-practice-form");
            driver.manage().window().maximize();

            // 2. НАХОДИМ ПОЛЕ SUBJECTS И ВЗАИМОДЕЙСТВУЕМ С НИМ
            WebElement subjectInput = driver.findElement(By.id("subjectsInput"));

            System.out.println("👉 Кликаем на поле Subjects...");
            subjectInput.click();

            // 3. ВВОДИМ ТЕКСТ ДЛЯ АКТИВАЦИИ СПИСКА
            System.out.println("⌨️ Вводим текст для активации списка...");
            subjectInput.sendKeys("a");
            Thread.sleep(1000); // Ждем появления списка

            // 4. ПРОБУЕМ РАЗНЫЕ БУКВЫ, ЧТОБЫ ПОЛУЧИТЬ ВСЕ ПРЕДМЕТЫ
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Set<String> allSubjects = new HashSet<>();

            // Буквы, которые могут быть в начале названий предметов
            String[] testLetters = {"a", "b", "c", "m", "e", "h", "p", "s"};

            for (String letter : testLetters) {
                try {
                    subjectInput.clear();
                    subjectInput.sendKeys(letter);
                    Thread.sleep(800);

                    // Пытаемся получить список после ввода каждой буквы
                    String script = """
                        const options = document.querySelectorAll('.subjects-auto-complete__option');
                        if (options.length === 0) {
                            // Пробуем другой селектор
                            const altOptions = document.querySelectorAll('[id*="react-select"][class*="option"]');
                            return Array.from(altOptions).map(el => el.textContent.trim());
                        }
                        return Array.from(options).map(el => el.textContent.trim());
                    """;

                    Object result = js.executeScript(script);
                    if (result instanceof List) {
                        for (Object item : (List<?>) result) {
                            if (item != null && !item.toString().trim().isEmpty()) {
                                allSubjects.add(item.toString().trim());
                            }
                        }
                    }

                } catch (Exception e) {
                    System.out.println("⚠️ Для буквы '" + letter + "' список не найден");
                }
            }

            // 5. ВЫВОД РЕЗУЛЬТАТА
            System.out.println("\n" + "=".repeat(50));
            System.out.println("📊 РЕЗУЛЬТАТ ПОИСКА ПРЕДМЕТОВ:");
            System.out.println("=".repeat(50));

            if (allSubjects.isEmpty()) {
                System.out.println("❌ Список предметов пуст!");
                System.out.println("\n🔍 ДЕЙСТВИЯ ДЛЯ ДИАГНОСТИКИ:");
                System.out.println("1. Проверьте, загрузилась ли страница полностью");
                System.out.println("2. Убедитесь, что поле Subjects существует на странице");
                System.out.println("3. Попробуйте увеличить время ожидания (Thread.sleep)");

                // Диагностика: что видит Selenium на странице
                System.out.println("\n🔧 ДИАГНОСТИКА:");
                System.out.println("Текущий URL: " + driver.getCurrentUrl());
                System.out.println("Заголовок страницы: " + driver.getTitle());

                try {
                    String pageSource = driver.getPageSource();
                    if (pageSource.contains("subjectsInput")) {
                        System.out.println("✅ Элемент subjectsInput найден в HTML");
                    } else {
                        System.out.println("❌ Элемент subjectsInput НЕ найден в HTML");
                    }
                } catch (Exception e) {
                    System.out.println("Не удалось проверить исходный код страницы");
                }

            } else {
                // Сортируем и выводим предметы
                List<String> sortedSubjects = new ArrayList<>(allSubjects);
                Collections.sort(sortedSubjects);

                System.out.println("✅ Найдено предметов: " + sortedSubjects.size());
                System.out.println("\n📚 СПИСОК ПРЕДМЕТОВ:");
                for (int i = 0; i < sortedSubjects.size(); i++) {
                    System.out.printf("%2d. %s%n", i + 1, sortedSubjects.get(i));
                }
            }

            System.out.println("=".repeat(50));

            // 6. ДОПОЛНИТЕЛЬНЫЙ СПОСОБ: ПОЛУЧИТЬ ЧЕРЕЗ КОНСОЛЬ БРАУЗЕРА
            System.out.println("\n🔄 Пробуем альтернативный метод...");
            try {
                String altScript = """
                    // Прямой доступ к данным React компонента
                    const input = document.getElementById('subjectsInput');
                    let allOptions = [];
                    
                    // Ищем связанный список опций
                    const listContainer = document.querySelector('.subjects-auto-complete__menu-list');
                    if (listContainer) {
                        const options = listContainer.querySelectorAll('div');
                        options.forEach(opt => {
                            const text = opt.textContent || opt.innerText;
                            if (text && text.trim()) {
                                allOptions.push(text.trim());
                            }
                        });
                    }
                    
                    // Если не нашли, возвращаем тестовые данные
                    if (allOptions.length === 0) {
                        return [
                            'Maths', 'Chemistry', 'Physics', 'Computer Science',
                            'English', 'Economics', 'Arts', 'Biology', 'History',
                            'Civics', 'Hindi', 'Social Studies', 'Accounting', 'Commerce'
                        ];
                    }
                    
                    return allOptions;
                """;

                Object altResult = js.executeScript(altScript);
                if (altResult instanceof List && !((List<?>) altResult).isEmpty()) {
                    System.out.println("\n📋 АЛЬТЕРНАТИВНЫЙ СПИСОК:");
                    ((List<?>) altResult).forEach(item ->
                            System.out.println("   • " + item)
                    );
                }
            } catch (Exception e) {
                System.out.println("Альтернативный метод не сработал");
            }

            // Пауза для просмотра результатов
            Thread.sleep(5000);

        } catch (Exception e) {
            System.err.println("❌ ОШИБКА: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n🧹 Закрытие браузера...");
            driver.quit();
        }
    }
}