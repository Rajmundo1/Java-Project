if not exist bin md bin
javac -d bin src\gunpowder_plot\*.java
java -cp bin gunpowder_plot.Main