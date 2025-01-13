
# Commands
```
mvn clean test => Run with default System Variable values
mvn clean test -Dbrowser=chrome -Dselenium.grid.enabled=true
```
# Package the code

```
mvn clean package -DskipTests

java -cp [Path_where_classes_are_present] org.testng.TestNG [suit_file_path]
```
# DOCKER

# SELENIUM GRID