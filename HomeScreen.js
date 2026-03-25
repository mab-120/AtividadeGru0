import {View, Text, TouchableOpacity, StyleSheet} from 'react-native';

export default function HomeScreen({ navigation }) {
  return (
    <View style={styles.container}>
    <Text style={styles.title}>Navegue entre o aplicativo:</Text>

    <Text style={styles.text}>Aqui você encontra tudo que é possível encontrar em nosso aplicativo. </Text>
    <TouchableOpacity
    style={styles.button}
    onPress={() => navigation.navigate('About')}>
    <Text style={styles.buttonText}>Sobre</Text>
    </TouchableOpacity>

    </View>
  );
}

const styles=StyleSheet.create({
  container: {
    flex: 1,
    justifyContent:'center',
    alignItems:'center',
    display: 'flex',
    padding: 20,
    backgroundColor: '#fff',
   
  },
  title: {
    fontSize: 26,
    fontWeight:'bold',
  },
  text: {
    marginVertical: 15,
    textAlign: 'justify'
  },
  button: {
    backgroundColor: '#556B2F',
    padding: 16,
    borderRadius: 100,
    alignItems: 'center',
    width: '80%',
    marginVertical: 20,
  },
  buttonText: {
    color: '#fff',
    fontWeight: 'bold',
    fontSize: 20,
  }
});