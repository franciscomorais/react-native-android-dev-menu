
# react-native-dev-tools-wrapper

## Getting started

`$ npm install react-native-dev-tools-wrapper --save`

### Mostly automatic installation

`$ react-native link react-native-dev-tools-wrapper`

### Manual installation


#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNDevToolsWrapperPackage;` to the imports at the top of the file
  - Add `new RNDevToolsWrapperPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-dev-tools-wrapper'
  	project(':react-native-dev-tools-wrapper').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-dev-tools-wrapper/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-dev-tools-wrapper')
  	```


## Usage
```javascript
import RNDevToolsWrapper from 'react-native-dev-tools-wrapper';

// TODO: What to do with the module?
RNDevToolsWrapper;
```
  