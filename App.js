import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

import HomeScreen from './screens/HomeScreen';
import AboutScreen from './screens/AboutScreen';
import ServicesScreen from './screens/ServicesScreen';
import ContactScreen from './screens/ContactScreen';
import FinalScreen from './screens/FinalScreen';

const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator initialRouteName="Home"
      screenOptions={{
        headerTitleAlign: 'center',
        headerStyle: {backgroundColor: '#000000'},
        headerTintColor: '#fff',
      }}
        >

        <Stack.Screen name="Home" 
        component={HomeScreen}
        options={{title: 'Ínicio'}}
        />

        <Stack.Screen name="About" 
        component={AboutScreen}
        options={{title: "Sobre"}} />

        <Stack.Screen name="Services" 
        component={ServicesScreen}
        options={{title:'Serviços'}} />

        <Stack.Screen name="Contact"
         component={ContactScreen}
         options={{title: "Contato"}} />

        <Stack.Screen name="Final"
         component={FinalScreen}
         options={{title: 'Final'}} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}
