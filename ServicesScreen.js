import {View, Text, TouchableOpacity, StyleSheet} from 'react-native';

export default function AboutScreen({ navigation }) {
  return (
    <View style={styles.container}>
    <Text style={styles.title}>Serviços</Text>

    <Text style={styles.text}>Serviçôs disponibilizados por nós:
     </Text>



        <TouchableOpacity
    style={styles.button}
    onPress={() => navigation.navigate('Contact')}>
    <Text style={styles.buttonText}>Contato</Text>
    </TouchableOpacity>

    </View>
  );
}

const styles=StyleSheet.create({
  container: {
    flex: 1,
    justifyContent:'center',
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
    textAlign: 'center'
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