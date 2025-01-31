
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

Clean, Compile and Package the code
Create Docker image
```
mvn clean package -DskipTests
docker build -t=<username>/selenium .
```

# SELENIUM GRID

Get the Grid Up and Running. Below will bring up 2 instances of Chrome 
Run the tests
```
docker-compose -f grid.yaml up --scale chrome=2 -d
BROWSER=chrome docker-compose up
```
Once successfully executed the results/reports are available under output folder

Run below to bring the Grid down

```
docker-compose -f grid.yaml down
```