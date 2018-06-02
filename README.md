
# Тесты для тестирования REST API Web-service ICNDb.com (The Internet Chuck Norris Database)
<h2>Оглавление</h2>
<ul>
<li>
1. <a href="#src/test/java">Папка с тестами "src/test/java".</a>
<ul>
<li>
1.1. <a href="#com.icndb.categories">Пакет "com.icndb.categories".</a>
<ul>   
<li>1.1.1. <a href="#TestCategories">Тестовый класс TestCategories.</a></li>
<ul>
<li><a href="#testAllCategories">Проверка всех категорий.</a></li>
<li><a href="#testIncorrectCategories">Проверка некоректной конечной точки.</a></li>
</ul>
<li>1.1.2. <a href="#TestExcludeCategories">Тестовый класс TestExcludeCategories.</a></li>
<ul>
<li><a href="#getJokesByExcludeCategories">Общий метод-запрос для тестов исключенных категорий.</a></li>
<li><a href="#testExcludeCategoriesPositive">Проверка исключенных категорий(Позитивный тест).</a></li>
<li><a href="#testExcludeCategoriesNegative">Проверка исключенных категорий(Негативный тест).</a></li>
</ul>
<li>1.1.3. <a href="#TestLimitToCategories">Тестовый класс TestLimitToCategories.</a></li>
<ul>
<li><a href="#getJokesByLimitToCategories">Общий метод-запрос для тестов ограниченных категорий.</a></li>
<li><a href="#testLimitToCategoriesPositive">Проверка ограниченных категорий(Позитивный тест).</a></li>
<li><a href="#testLimitToCategoriesNegative">Проверка ограниченных категорий(Негативный тест).</a></li>
</ul>
</li>
</ul>
</ul>
<ul>
<li>
1.2. <a href="#com.icndb.jokes">Пакет "com.icndb.jokes".</a>
<ul>
<li>1.2.1. <a href="#TestJokes">Тестовый класс TestJokes.</a></li>
<ul>
<li><a href="#testCountOfJokes">Проверка количества отображаемых шуток.</a></li>
<li><a href="#testCountOfDisplayedJokes">Проверка количества шуток.</a></li>
<li><a href="#getJokesById">Общий метод-запрос для тестов проверки идентификатора шутки.</a></li>
<li><a href="#testJokesByIdPositive">Проверка идентификатора шутки(Позитивный тест).</a></li>
<li><a href="#testJokesByIdNegative">Проверка идентификатора шутки(Негативный тест).</a></li>
<li><a href="#testIncorrectEndPointAfterJokes">Проверка некоректной конечной точки.</a></li>
</ul>
</ul>
</li>
</ul>
<ul>
<li>
1.3. <a href="#com.icndb.random_jokes">Пакет "com.icndb.random_jokes".</a>
<ul>
<li>1.3.1. <a href="#TestRandomJokes">Тестовый класс TestRandomJokes.</a></li>
<ul>
<li><a href="#testRandomJoke">Проверка рандомной шутки.</a></li>
<li><a href="#getCountOfRandomJokes">Общий метод-запрос для тестов количества рандомных шуток.</a></li>
<li><a href="#testCountOfRandomJokesPositive">Проверка количества рандомных шуток(Позитивный тест).</a></li>
<li><a href="#testCountOfRandomJokesNegative">Проверка количества рандомных шуток(Негативный тест).</a></li>
<li><a href="#testChangeOfFirstnameAndLastname">Проверка изменения имени и фамилии у персонажа шутки.</a></li>
</ul>
</ul>
</li>
</ul>
</li>
</ul>
<ul>
<li>
2. <a href="#src/test/test_resources">Папка с тест ресурсами "src/test/test_resources".</a>
<ul>
<li>
2.1. <a href="#com.icndb.endPoints">Пакет "com.icndb.endPoints".</a>
<ul>
<li>2.1.1. <a href="#EndPoints">Интерфейс EndPoints.</a></li>
<ul>
<li><a href="#endPoint">Метод endPoint().</a></li>
</ul>
<li>2.1.2. <a href="#CorrectEndPoints">Перечисление с корректными конечными точками CorrectEndPoints.</a></li>
<li>2.1.3. <a href="#IncorrectEndPoints">Перечисление с некорректными конечными точками IncorrectEndPoints.</a></li>
</li>
</ul>
</ul>
<ul>
<li>
2.2. <a href="#com.icndb.resources_data">Пакет "com.icndb.resources_data".</a>
<ul>
<li>2.2.1. <a href="#DataProviderForJokes">Класс с данными DataProviderForJokes.</a></li>
<ul>
<li><a href="#getListProperty">Метод getListProperty(InputStream fileProper, String key).</a></li>
<li><a href="#getListOfAllCategories">Метод getListOfAllCategories().</a></li>
<li><a href="#positiveIdJoke">Метод поставки данных positiveIdJoke().</a></li>
<li><a href="#negativeIdJoke">Метод поставки данных negativeIdJoke().</a></li>
<li><a href="#positiveCountOfRandomJokes">Метод поставки данных positiveCountOfRandomJokes().</a></li>
<li><a href="#negativeCountOfRandomJokes">Метод поставки данных negativeCountOfRandomJokes().</a></li>
<li><a href="#positiveExcludeAndLimitTo">Метод поставки данных positiveExcludeAndLimitTo().</a></li>
<li><a href="#negativeExcludeAndLimitTo">Метод поставки данных negativeExcludeAndLimitTo().</a></li>
<li><a href="#getListOfCategories">Метод getListOfCategories(String ...categor).</a></li>
</ul>
<li>2.2.2. <a href="#RestUtilities">Класс RestUtilities.</a></li>
<ul>
<li><a href="#getJsonPath">Метод getJsonPath(Response res).</a></li>
<li><a href="#addAttachmentToReport">Метод addAttachmentToReport(String name, String content).</a></li>
<li><a href="#addAttachmentToReportList">Метод addAttachmentToReport(String name, List<String> content).</a></li>
<li><a href="#assertionType">Метод assertionType(JsonPath path, String typeStatus).</a></li>
</ul>
<li>2.2.3. <a href="#Categories">Файл Categories с категориями шуток.</a></li>
</li>
</ul>
</ul>
<ul>
<li>
2.3. <a href="#com.icndb.specification">Пакет "com.icndb.specification".</a>
<ul>
<li>2.3.1. <a href="#InitialConfiguration">Класс с начальной конфигурацией InitialConfiguration.</a></li>
<ul>
<li><a href="#setUpSuite">Метод начальной конфигурацией setUpSuite().</a></li>
</ul>
<li>2.3.2. <a href="#UtilitiesRequestSpecification">Класс со спецификациями для запроса UtilitiesRequestSpecification.</a></li>
<ul>
<li><a href="#setEndPoint">Метод setEndPoint(EndPoints endPoint).</a></li>
<li><a href="#createPathParam">Метод createPathParam(String param, String value).</a></li>
<li><a href="#createPathParamInt">Метод createPathParam(String param, int value).</a></li>
<li><a href="#createParam">Метод createParam(String param, String value).</a></li>
</ul>
<li>2.3.3. <a href="#UtilitiesResponseSpecification">Класс со спецификациями для ответа UtilitiesResponseSpecification.</a></li>
<ul>
<li><a href="#setStatusCode">Метод setStatusCode(int statusCode).</a></li>
</ul>
</ul>
</li>
</ul>
</li>
</ul>
<ul>
<li>
3. <a href="#XML_RUN">Папка XML_RUN.</a>
<ul>
<li>
3.1. <a href="#Run_all_test.xml">TestNG XML файл для запуска всех тестов Run_all_test.xml.</a>
</li>
</ul>
</li>
</ul>
<ul>
<li>
4. <a href="https://github.com/MechaniC1024/ICNDB_TEST_REST_API/tree/master/Test_suite">Тестовые наборы.</a>
</li>
</ul>
<ul>
<li>
5. <a href="http://www.icndb.com/api/">Документация по API.
</li>
</ul>
</br>
</br>
</br>
</br>
</br>
<h2><a name="src/test/java"/>1. Папка с тестами "src/test/java".</h2>

<h3><a name="com.icndb.categories"/>1.1. Пакет "com.icndb.categories".</h3>
<h4><a name="TestCategories"/>1.1.1. Тестовый класс TestCategories.</h4>

<h5><a name="testAllCategories"/>Проверка всех категорий.</h5>
<p>Проверяем верные ли категории выдаются по запросу.</p>
    
    public void testAllCategories() {

    Response res = 
        given().
            spec(setEndPoint(CorrectEndPoints.CATEGORIES)).
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();
            
    JsonPath jsonPath = getJsonPath(res);
		
    assertionType(jsonPath, "success");
	
    List<String> listCategorJson = jsonPath.getList("value");		
    Collections.sort(listCategorJson);		
		
    List<String> listCategor = DataProviderForJokes.getListOfAllCategories();

    Assert.assertEquals(listCategorJson, listCategor);		

    }

<h5><a name="testIncorrectCategories"/>Проверка некоректной конечной точки.</h5>
<p>Проверяем некорректную конечную точку на статус код 404.</p>

    public void testIncorrectCategories() {

        given().
            spec(setEndPoint(IncorrectEndPoints.INCORRECT_END_POINTS_CATEGO)).
        when().
            get().
        then().
            spec(setStatusCode(404));
    }


<h4><a name="TestExcludeCategories"/>1.1.2. Тестовый класс TestExcludeCategories.</h4>

<h5><a name="getJokesByExcludeCategories"/>Общий метод-запрос для тестов исключенных категорий.</h5>
<p>Общий метод-запрос, который выполняется при позитивном, так и при негативном тестировании.</p>
    
    private static JsonPath getJokesByExcludeCategories(String categor1, String categor2) {
		
    String param = categor1 + "," + categor2;
    Response res = 
        given().
            spec(setEndPoint(CorrectEndPoints.JOKES)).
            spec(createParam("exclude", param)). 
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();
 
        return getJsonPath(res);		
    }
    
<h5><a name="testExcludeCategoriesPositive"/>Проверка исключенных категорий(Позитивный тест).</h5>
<p>Проверяем категории у шуток, чтобы шутка не содержала категорий которые мы исключили из поиска. Данные для проверок,
мы берем из метода <b>"positiveExcludeAndLimitTo"</b>, который находиться в классе <b>"DataProviderForJokes"</b>.</p>
    
    @Test(description = "Checking function limitTo (Positive test).", dataProvider = "positiveExcludeAndLimitTo", dataProviderClass = DataProviderForJokes.class)
    public void testExcludeCategoriesPositive(String categor1, String categor2) {
		
    List<String> listOfCategories = getListOfCategories(categor1, categor2);
		
    JsonPath jsonPath = getJokesByExcludeCategories(categor1, categor2);
		
    assertionType(jsonPath, "success");
		
    addAttachmentToReport("CATEGORIES: ", categor1 + ", " + categor2 + ".");
		
    int countOfCategories = jsonPath.getList("value.id").size();
		
    SoftAssert softAssert = new SoftAssert();
		
    for(int i = 0; i < countOfCategories; i++) {
			
      int id = jsonPath.getInt("value["+i+"].id");
      List<String> catig = jsonPath.getList("value["+i+"].categories");		
						
      boolean contain = Collections.disjoint(catig, listOfCategories);
			
      if(contain == false) {
        softAssert.assertEquals(contain, true);
        addAttachmentToReport("ID = " + id + ": ", catig);
      }			
     }
     softAssert.assertAll();		
    }
    
<h5><a name="testExcludeCategoriesNegative"/>Проверка исключенных категорий(Негативный тест).</h5>
<p>Проверяем сообщение из JSON ответа, атрибут type = "NoSuchCategoryException". Данные для проверок,
мы берем из метода <b>"negativeExcludeAndLimitTo"</b>, который находиться в классе <b>"DataProviderForJokes"</b>.</p>
    
    @Test(description = "Checking function exclude (Negative test).", dataProvider = "negativeExcludeAndLimitTo", dataProviderClass = DataProviderForJokes.class)
    public void testExcludeCategoriesNegative(String categor1, String categor2) {
		
    JsonPath jsonPath = getJokesByExcludeCategories(categor1, categor2);
		
    assertionType(jsonPath, "NoSuchCategoryException");		
    }
    
<h4><a name="TestLimitToCategories"/>1.1.3. Тестовый класс TestLimitToCategories.</h4>

<h5><a name="getJokesByLimitToCategories"/>Общий метод-запрос для тестов ограниченных категорий.</h5>
<p>Общий метод-запрос, который выполняется при позитивном, так и при негативном тестировании.</p>
    
    private static JsonPath getJokesByLimitToCategories(String categor1, String categor2) {
		
    String param = categor1 + "," + categor2;
    Response res = 
        given().
            spec(setEndPoint(CorrectEndPoints.JOKES)).
            spec(createParam("limitTo", param)). 
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();
		
        return getJsonPath(res);		
     }
    
<h5><a name="testLimitToCategoriesPositive"/>Проверка ограниченных категорий(Позитивный тест).</h5>
<p>Проверяем категории у шуток, чтобы шутка содержала категорий которые мы включили в поиск. Данные для проверок,
мы берем из метода <b>"positiveExcludeAndLimitTo"</b>, который находиться в классе <b>"DataProviderForJokes"</b>.</p>
    
    @Test(description = "Checking function limitTo (Positive test).", dataProvider = "positiveExcludeAndLimitTo", dataProviderClass = DataProviderForJokes.class)
    public void testLimitToCategoriesPositive(String categor1, String categor2) {
		
    List<String> listOfCategories = getListOfCategories(categor1, categor2);
		
    JsonPath jsonPath = getJokesByLimitToCategories(categor1, categor2);
		
    assertionType(jsonPath, "success");	
		
    addAttachmentToReport("CATEGORIES: ", categor1 + ", " + categor2 + ".");
		
    int countOfCategories = jsonPath.getList("value.id").size();
		
    SoftAssert softAssert = new SoftAssert();
		
    for(int i = 0; i < countOfCategories; i++) {
			
      int id = jsonPath.getInt("value["+i+"].id");
      List<String> catig = jsonPath.getList("value["+i+"].categories");		
						
      boolean contain = catig.containsAll(listOfCategories);
			
      if(!contain == false) {
        softAssert.assertEquals(contain, true);
        addAttachmentToReport("ID = " + id + ": ", catig);
       }			
     }
		
     softAssert.assertAll();		
    }
    
<h5><a name="testLimitToCategoriesNegative"/>Проверка ограниченных категорий(Негативный тест).</h5>
<p>Проверяем сообщение из JSON ответа, атрибут type = "NoSuchCategoryException". Данные для проверок,
мы берем из метода <b>"negativeExcludeAndLimitTo"</b>, который находиться в классе <b>"DataProviderForJokes"</b>.</p>
    
    @Test(description = "Checking function limitTo (Negative test).", dataProvider = "negativeExcludeAndLimitTo", dataProviderClass = DataProviderForJokes.class)
    public void testLimitToCategoriesNegative(String categor1, String categor2) {
		
    JsonPath jsonPath = getJokesByLimitToCategories(categor1, categor2);
		
    assertionType(jsonPath, "NoSuchCategoryException");	
    }
    

<h3><a name="com.icndb.jokes"/>1.2. Пакет "com.icndb.jokes".</h3>
<h4><a name="TestJokes"/>1.2.1. Тестовый класс TestJokes.</h4>
<h5><a name="testCountOfJokes"/>Проверка количества отображаемых шуток.</h5>
<p>Проверяем, что отображаются все шутки по запросу.</p>
    
    public void testCountOfJokes() {
		Response res = 
        given().
            spec(setEndPoint(CorrectEndPoints.COUNT_OF_JOKES)).
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();

    JsonPath jsonPath = getJsonPath(res);
		
    assertionType(jsonPath, "success");	

    int countOfJokes = jsonPath.get("value");		
				
    Assert.assertEquals(countOfJokes, DataProviderForJokes.COUNT_OF_JOKES);	
    }
    
<h5><a name="testCountOfDisplayedJokes"/>Проверка количества шуток.</h5>
<p>Проверяем, что отображается верное количество шуток.</p>
    
    public void testCountOfDisplayedJokes() {
    Response res = 
        given().
            spec(setEndPoint(CorrectEndPoints.JOKES)).
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();

    JsonPath jsonPath = getJsonPath(res);

    assertionType(jsonPath, "success");	
		
    List<String> allJokes = jsonPath.getList("value");		
				
    Assert.assertEquals(allJokes.size(), DataProviderForJokes.COUNT_OF_JOKES);	
    }
    
<h5><a name="getJokesById"/>Общий метод-запрос для тестов проверки идентификатора шутки.</h5>
<p>Общий метод-запрос, который выполняется при позитивном, так и при негативном тестировании.</p>
    
    private JsonPath getJokesById(String id) {		
    Response res = 
        given().
            spec(setEndPoint(CorrectEndPoints.ID_JOKE)).
            spec(createPathParam("id", id)).
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();
    return getJsonPath(res);
    }
    
<h5><a name="testJokesByIdPositive"/>Проверка идентификатора шутки(Позитивный тест).</h5>
<p>Проверяем идентификаторы у шуток и их статус, чтобы шутка содержала тот же идентификатор по которому мы ее искали. 
Данные для проверок, мы берем из метода "positiveIdJoke", который находиться в классе "DataProviderForJokes".</p>
    
    @Test(description = "Checking jokes by id (Positive test).", dataProvider = "positiveIdJoke", dataProviderClass = DataProviderForJokes.class)
    public void testJokesByIdPositive(String id) {

    JsonPath jsonPath = getJokesById(id);

    assertionType(jsonPath, "success");	
		
    int idJokes = jsonPath.get("value.id");		
				
    Assert.assertEquals(idJokes, Integer.parseInt(id));	
    }
    
<h5><a name="testJokesByIdNegative"/>Проверка идентификатора шутки(Негативный тест).</h5>
<p>Проверяем сообщение из JSON ответа, атрибут type = "NoSuchQuoteException". 
Данные для проверок, мы берем из метода "negativeIdJoke", который находиться в классе "DataProviderForJokes".</p>

    @Test(description = "Checking jokes by id (Negative test).", dataProvider = "negativeIdJoke", dataProviderClass = DataProviderForJokes.class)
    public void testJokesByIdNegative(String id) {
		
    JsonPath jsonPath = getJokesById(id);
		
    assertionType(jsonPath, "NoSuchQuoteException");	
    }
    
<h5><a name="testIncorrectEndPointAfterJokes"/>Проверка некоректной конечной точки.</h5>
<p>Проверяем некорректную конечную точку на статус код 404.</p>
    
    public void testIncorrectEndPointAfterJokes() {

        given().
            spec(setEndPoint(IncorrectEndPoints.INCORRECT_END_POINTS_AFTER_JOKES)).
        when().
            get().
        then().
            spec(setStatusCode(404));
    }
    


<h3><a name="com.icndb.random_jokes"/>1.3. Пакет "com.icndb.random_jokes".</h3>
<h4><a name="TestRandomJokes"/>1.3.1. Тестовый класс TestRandomJokes.</h4>
<h5><a name="testRandomJoke"/>Проверка рандомной шутки.</h5>
<p>Проверяем статус рандомной шутки.</p>
    
    public void testRandomJoke() {
    Response res = 
        given().
            spec(setEndPoint(CorrectEndPoints.RANDOM_JOKE)).
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();
    JsonPath jsonPath = getJsonPath(res);
		
    assertionType(jsonPath, "success");	
		
    int id = jsonPath.getInt("value.id");
		
    String joke = jsonPath.getString("value.joke");
		
    addAttachmentToReport("Randome joke and her id", id + " - " + joke);
	
    }
    
<h5><a name="getCountOfRandomJokes"/>Общий метод-запрос для тестов количества рандомных шуток.</h5>
<p>Общий метод-запрос, который выполняется при позитивном, так и при негативном тестировании.</p>
    
    private JsonPath getCountOfRandomJokes(String count) {
    Response res = 
        given().
            spec(setEndPoint(CorrectEndPoints.RANDOM_JOKES)).
            spec(createPathParam("count", count)).
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();
    return getJsonPath(res);
    }
    
<h5><a name="testCountOfRandomJokesPositive"/>Проверка количества рандомных шуток(Позитивный тест).</h5>
<p>Проверяем количество рандомных шуток, с тем количество которое мы запросили. 
Данные для проверок, мы берем из метода "positiveCountOfRandomJokes", который находиться в классе "DataProviderForJokes".</p>
    
    @Test(description = "Check the count of random jokes (Positive test).", dataProvider = "positiveCountOfRandomJokes", dataProviderClass = DataProviderForJokes.class)
    public void testCountOfRandomJokesPositive(String count) {

    JsonPath jsonPath = getCountOfRandomJokes(count);

    assertionType(jsonPath, "success");	
		
    List<Integer> idJokes = jsonPath.get("value.id");		
				
    Assert.assertEquals(idJokes.size(), Integer.parseInt(count));	
    }
    
<h5><a name="testCountOfRandomJokesNegative"/>Проверка идентификатора шутки(Негативный тест).</h5>
<p>Проверяем сообщение из JSON ответа, атрибут type = "NoSuchQuoteException". 
Данные для проверок, мы берем из метода "negativeCountOfRandomJokes", который находиться в классе "DataProviderForJokes".</p>
    
    @Test(description = "Check the count of random jokes (Negative test).", dataProvider = "negativeCountOfRandomJokes", dataProviderClass = DataProviderForJokes.class)
    public void testCountOfRandomJokesNegative(String count) {
		
    JsonPath jsonPath = getCountOfRandomJokes(count);
		
    assertionType(jsonPath, "NoSuchQuoteException");	
    }
    
<h5><a name="testChangeOfFirstnameAndLastname"/>Проверка изменения имени и фамилии у персонажа шутки.</h5>
<p>Проверяем изменяется ли имя и фамилия у рандомной шутки. Изменяем имя и фамилию в рандомной шутки
и потом рандомную шутку сравниваем с оригинальной шуткой.</p>
    
    public void testChangeOfFirstnameAndLastname() {
    Response resRandomJoke = 
        given().
            spec(setEndPoint(CorrectEndPoints.RANDOM_JOKE)).
            spec(createParam("firstName", FIRST_NAME_OF_CHARACTER)).
            spec(createParam("lastName", LAST_NAME_OF_CHARACTER)).
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();
		
    JsonPath jsonPathRan = getJsonPath(resRandomJoke);
		
    assertionType(jsonPathRan, "success");	
		
    int idJokeRan = jsonPathRan.get("value.id");
    String jokeRan = jsonPathRan.get("value.joke");
		
    Response resJokeById = 
        given().
            spec(setEndPoint(CorrectEndPoints.ID_JOKE)).
            spec(createPathParam("id", idJokeRan)).
        when().
            get().
        then().
            spec(setStatusCode(200)).
            extract().
            response();
		
    JsonPath jsonPath = getJsonPath(resJokeById);
		
    assertionType(jsonPath, "success");	
		
    String joke = jsonPath.get("value.joke");

    addAttachmentToReport("Both jokes", "Joke before change: " + joke + "\n\n" + "Joke after change: " + jokeRan);
		
    Assert.assertNotEquals(jokeRan, joke);		
    }
    
<h2><a name="src/test/test_resources"/>2. Папка с тест ресурсами "src/test/test_resources".</h2>

<h3><a name="com.icndb.endPoints"/>2.1. Пакет "com.icndb.endPoints".</h3>
<h4><a name="EndPoints"/>2.1.1. Интерфейс EndPoints.</h4>
<h5><a name="endPoint"/>Метод endPoint().</h5>
<p>Метод который реализуют два перечисления "CorrectEndPoints", "IncorrectEndPoints".</p>

    public String endPoint();
 

<h4><a name="CorrectEndPoints"/>2.1.2. Перечисление с корректными конечными точками CorrectEndPoints.</h4>
<p>Перечисление которое описывает корректные конечные точки API.</p>

    CATEGORIES {
      public String endPoint() {
        return "/categories";
      }
    },
    JOKES {
      public String endPoint() {
        return "/jokes";
      }
    },
    ID_JOKE {
      public String endPoint() {
        return "jokes/{id}";
      }
    },
    COUNT_OF_JOKES {
      public String endPoint() {
        return "/jokes/count";
      }
    },
    RANDOM_JOKE {
      public String endPoint() {
        return "/jokes/random";
      }
    },
    RANDOM_JOKES {
      public String endPoint() {
        return "/jokes/random/{count}";
      }
    };

<h4><a name="IncorrectEndPoints"/>2.1.3. Перечисление с некорректными конечными точками IncorrectEndPoints.</h4>
<p>Перечисление которое описывает некорректные конечные точки API.</p>
    
    INCORRECT_END_POINTS_JOK {
      public String endPoint() {
        return "/jok";
      }
    },
    INCORRECT_END_POINTS_CATEGO {
      public String endPoint() {
        return "/catego";
      }
    },
    INCORRECT_END_POINTS_AFTER_JOKES {
      public String endPoint() {
        return "/jokes/qwerty";
      }
    };
    
<h3><a name="com.icndb.resources_data"/>2.2. Пакет "com.icndb.resources_data".</h3>
<h4><a name="DataProviderForJokes"/>2.2.1. Класс с данными DataProviderForJokes.</h4>
<h5><a name="getListProperty"/>Метод getListProperty(InputStream fileProper, String key).</h5>
<p>Метод считывает данные с проперти файла и возвращает список с данными.</p>
    
    private static List<String> getListProperty(InputStream fileProper, String key) {
    Properties prop = new Properties();

    try {
      prop.load(fileProper);
    } catch (IOException e) {
      addAttachmentToReport("Exception: IOException", e.getMessage());
    }

    String strCategor = prop.getProperty(key);
    List<String> listCategor = Arrays.asList(strCategor.split(","));
    Collections.sort(listCategor);
    return listCategor;
    }
    
<h5><a name="getListOfAllCategories"/>Метод getListOfAllCategories().</h5>
<p>Метод возвращает список с категориями шуток используя метод "getListProperty".</p>
    
    public static List<String> getListOfAllCategories() {
    List<String> listCategor = new ArrayList<>();
    try {
      listCategor = getListProperty(new FileInputStream(pathToCategory), keyCategories);
    } catch (FileNotFoundException e) {
      addAttachmentToReport("Exception: FileNotFoundException", e.getMessage());
    }
    return listCategor;
    }
    
<h5><a name="positiveIdJoke"/>Метод поставки данных positiveIdJoke().</h5>
<p>Метод предоставляет корректные идентификаторы шуток для тестов.</p> 
    
    @DataProvider
    public Object[][] positiveIdJoke() {
     return new Object[][] { { "1" }, { "385" }, { "603" } };
    }
    
<h5><a name="negativeIdJoke"/>Метод поставки данных negativeIdJoke().</h5>
<p>Метод предоставляет некорректные идентификаторы шуток для тестов.</p> 
    
    @DataProvider
    public Object[][] negativeIdJoke() {
     return new Object[][] { { "0" }, { "-1" }, { "1.5" } };
    }
    
<h5><a name="positiveCountOfRandomJokes"/>Метод поставки данных positiveCountOfRandomJokes().</h5>
<p>Метод предоставляет корректные количества шуток для тестов.</p>
    
    @DataProvider
    public Object[][] positiveCountOfRandomJokes() {
     return new Object[][] { { "1" }, { "558" }, { "300" }, { "1000" } };
    }
    
<h5><a name="negativeCountOfRandomJokes"/>Метод поставки данных negativeCountOfRandomJokes().</h5>
<p>Метод предоставляет некорректные количества шуток для тестов.</p>
    
    @DataProvider
    public Object[][] negativeCountOfRandomJokes() {
     return new Object[][] { { "0" }, { "-1" }, { "1.5" }, { "qwery" } };
    }
    
<h5><a name="positiveExcludeAndLimitTo"/>Метод поставки данных positiveExcludeAndLimitTo().</h5>
<p>Метод предоставляет корректные категории шуток для тестов.</p>
    
    @DataProvider
    public Object[][] positiveExcludeAndLimitTo() {
     return new Object[][] { { "explicit", "" }, { "explicit", "nerdy" }, { "nerdy", "" } };
    }
    
<h5><a name="negativeExcludeAndLimitTo"/>Метод поставки данных negativeExcludeAndLimitTo().</h5>
<p>Метод предоставляет некорректные категории шуток для тестов.</p>
    
    @DataProvider
    public Object[][] negativeExcludeAndLimitTo() {
     return new Object[][] { { "qwerty", "" }, { "qwerty", "123" }, { "", "" }, { "explicit", "qwerty" } };
    }
    
<h5><a name="getListOfCategories"/>Метод getListOfCategories(String ...categor).</h5>
<p>Метод преобразует аргумент переменной длины в список.</p>
    
    public static List<String> getListOfCategories(String ...categor){
    List<String> listOfCategor = new LinkedList<>();		
      for(int i = 0; i < categor.length; i++) {
        listOfCategor.add(categor[i]);
      }
     return listOfCategor;		
    }
    
<h4><a name="RestUtilities"/>2.2.2. Класс RestUtilities.</h4>
<h5><a name="getJsonPath"/>Метод getJsonPath(Response res).</h5>
<p>Метод преобразует ответ запроса в JsonPath.</p>
    
    public static JsonPath getJsonPath(Response res) {
     String path = res.asString();
    return new JsonPath(path);
    }
    
<h5><a name="addAttachmentToReport"/>Метод addAttachmentToReport(String name, String content).</h5>
<p>Метод добавляе информацию в репорт.</p>
    
    public static void addAttachmentToReport(String name, String content) {
     Allure.addAttachment(name, content);
    }
    
<h5><a name="addAttachmentToReportList"/>Метод addAttachmentToReport(String name, List<String> content).</h5>
<p>Метод добавляет список информации в репорт.</p>
    
    public static void addAttachmentToReport(String name, List<String> content) {
     String list = "";
     for (String i : content) {
      list += i + " ";
     }

    ByteArrayInputStream bais = new ByteArrayInputStream(list.getBytes());

    Allure.addAttachment(name, bais);

    try {
    bais.close();
    } catch (IOException e) {
    addAttachmentToReport("Exception: ", e.getMessage());
    }
    }
    
<h5><a name="assertionType"/>Метод assertionType(JsonPath path, String typeStatus).</h5>
<p>Метод для проверки статуса шутки.</p>
    
    public static void assertionType(JsonPath path, String typeStatus) {
     String type = path.get("type");
     Assert.assertEquals(type, typeStatus);
    }
    
<h4><a name="Categories"/>2.2.3. Файл Categories с категориями шуток.</h4>
<p>Файл в котором описывается список категорий шуток.</p>

<h3><a name="com.icndb.specification"/>2.3. Пакет "com.icndb.specification".</h3>
<h4><a name="InitialConfiguration"/>2.3.1. Класс с начальной конфигурацией InitialConfiguration.</h4>
<h5><a name="setUpSuite"/>Метод начальной конфигурацией setUpSuite().</h5>
<p>Конфигурация для всех тестов.</p>
    
    @BeforeSuite(description = "Initial configuration suite.")
    public void setUpSuite() {
		
    RestAssured.baseURI = "http://api.icndb.com";
		
    }	
    
<h4><a name="UtilitiesRequestSpecification"/>2.3.2. Класс со спецификациями для запроса UtilitiesRequestSpecification.</h4>
<h5><a name="setEndPoint"/>Метод setEndPoint(EndPoints endPoint).</h5>
<p>Метод устанавливает спецификацию в виде конечной точки.</p>
    
    public static RequestSpecification setEndPoint(EndPoints endPoint) {

     RequestSpecBuilder requestBuilder = new RequestSpecBuilder();
     requestBuilder.addFilter(new AllureRestAssured());
     requestBuilder.setBasePath(endPoint.endPoint());
     requestSpec = requestBuilder.build();
     return requestSpec;
    }
    
<h5><a name="createPathParam"/>Метод createPathParam(String param, String value).</h5>
<p>Метод устанавливает спецификацию в виде путевого параметра.</p>
    
    public static RequestSpecification createPathParam(String param, String value) {		
     return requestSpec.pathParam(param, value);
    }
    
<h5><a name="createPathParamInt"/>Метод createPathParam(String param, int value).</h5>
<p>Метод устанавливает спецификацию в виде путевого параметра.</p>
    
    public static RequestSpecification createPathParam(String param, int value) {		
     return requestSpec.pathParam(param, value);
    }
    
<h5><a name="createParam"/>Метод createParam(String param, String value).</h5>
<p>Метод устанавливает спецификацию в виде параметра, который будет отправлен с запросом.</p>
    
    public static RequestSpecification createParam(String param, String value) {		
     return requestSpec.param(param, value);
    }
    
<h4><a name="UtilitiesResponseSpecification"/>2.3.3. Класс со спецификациями для ответа UtilitiesResponseSpecification.</h4>
<h5><a name="setStatusCode"/>Метод setStatusCode(int statusCode).</h5>
<p>Метод устанавливает спецификацию в виде проверки статус кода и что ответ пришел в виде JSON формата.</p>

    public static ResponseSpecification setStatusCode(int statusCode) {

     ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
     responseBuilder.expectContentType(ContentType.JSON);
     responseBuilder.expectStatusCode(statusCode);
     ResponseSpecification responseSpec = responseBuilder.build();
     return responseSpec;
    }

<h2><a name="XML_RUN"/>3. Папка XML_RUN.</h2>
<h3><a name="Run_all_test.xml"/>3.1. TestNG XML файл для запуска всех тестов Run_all_test.xml.</h3>
<p>XML файл для запуска тестов, в котором указаны пакеты с тестами для запуска.</p>
    
    <suite name="Icndb" verbose="1">
      <test name="Test categories.">
       <packages>
        <package name="com.icndb.categories" />
       </packages>
      </test>

      <test name="Test jokes.">
       <packages>
        <package name="com.icndb.jokes" />
       </packages>
      </test>

      <test name="Test random jokes.">
       <packages>
        <package name="com.icndb.random_jokes" />
       </packages>
      </test>
    </suite>  