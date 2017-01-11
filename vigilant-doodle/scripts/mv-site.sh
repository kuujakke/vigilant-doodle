#!/bin/bash

echo "Moving PIT -report"
rsync -a target/pit-reports/*/ ../dokumentaatio/pit-raportti/

echo "Moving javadoc..."
rsync -a ../dokumentaatio/checkstyle-raportti/apidocs/ ../dokumentaatio/javadoc/
rm -r ../dokumentaatio/checkstyle-raportti/apidocs

echo "Moving .jar..."
rsync -a target/vigilant-doodle-0.1.jar ../vigilant-doodle.jar